package griffith;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
	private static final String FileLog = "Amount.txt"; 
	//file name for the storing issues, for some reason String file ="amount.txt" did not work.
	//eclipse adviced the keeping the variable with private static final and it worked.

	public static void main(String[] args) {
		String fileWords = "Words.csv";
		reverse(fileWords);

		String fileReceipt = "receipt.txt";
		boolean result = priceVerify(fileReceipt);
		System.out.println("Price verification result: " + result);
	    
	    logAmount(10);
        logAmount(23);
        logAmount(45);
        logAmount(67);
        logAmount(67); 

        getAmountByDate("02-12");
        
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter an URL to download:  ");
            String url = br.readLine();
            System.out.print("Enter an location on your PC to save the file: ");
            String location = br.readLine();
            download(url, location);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
	}

	public static void reverse(String filename) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename.split("\\.")[0] + "_reversed.csv"));
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String[] sentence;
			String line;
			while ((line = reader.readLine()) != null) {
				sentence = line.split(",");
				for (int i = sentence.length - 1; i >= 0; i--) {
					writer.write(sentence[i]);
					if (i != 0) {
						writer.write(",");
					}
				}
				writer.newLine();
			}
			writer.close();
			reader.close();
			System.out.println("File successfully reversed and saved as " + filename.split("\\.")[0] + "_reversed.csv");
		} catch (IOException e) {
			System.out.println("You faced with an error called: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean priceVerify(String fileName) {
		boolean result = false;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			double total = 0.0;
			//for calculating the total amount.
			double totalWritten = 0.0;
			//for finding the total amount that is written.
			while ((line = reader.readLine()) != null) {
				String[] sides = line.split(" : ");
				if (sides.length == 2) {
					String productName = sides[0].trim();
					double price = Double.parseDouble(sides[1].trim());
					total += price;
					//what this code basically do is, gets the : as a side definer
					//and declares the left side as the product name, right side as the price amount.
					if(productName.equals("Total")) {
						totalWritten = Double.parseDouble(sides[1].trim());
						//instead of using the lastLine i tried to make it act like product named total is will be equal to totalWritten
						//so total price would be comparable with the total that is written.
						

					} 
				}
				
			}
			reader.close();
			
			 if (total == totalWritten) {
		            result = true;
		            //for giving the result.
		        }
		}
		catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
			//error message.
		}
		return result;

	}

	public static void logAmount(int amount) {
        try {
            File file = new File(FileLog);
            FileWriter fileWriter = new FileWriter(file, true); 
            BufferedWriter writer = new BufferedWriter(fileWriter);

            List<String> lines = Files.readAllLines(Paths.get(FileLog));
            // That is basically going to check if the given amount is equal to last entry
            if (!lines.isEmpty()) {
                String lastLine = lines.get(lines.size() - 1);
                String[] parts = lastLine.split(", ");
                int lastAmount = Integer.parseInt(parts[0]);
                if (amount == lastAmount) {
                    writer.close();
                    return;
                    //after finding the last amount we return.
                }
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            //going to keep the date format with the format of 
            // day-month-year and hour-minute-second.
            String formattedDate = dateFormat.format(new Date());
            writer.write(amount + ", " + formattedDate + " UPDATED");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get logged amounts by date
    public static void getAmountByDate(String startDate) {
        try {
            File file = new File(FileLog);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String date = parts[1].substring(0, 5); 
                //substring the date from the line
                if (date.equals(startDate)) {
                    System.out.println(line);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void download(String url, String location) {
        try {
            // Get the file name from the URL
            String name = url.substring(url.lastIndexOf('/') + 1);

            // Check if the file already exists in the location
            File file = new File(location, name);
            int counter = 1;
            while (file.exists()) {
                System.out.println("File '" + name + "' exists in the location.");
                System.out.println("To overwrite it type 'yes' or 'no'");
                
                
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String input = reader.readLine();
                if (input.equalsIgnoreCase("yes")) {
                    break;
                } else if (input.equalsIgnoreCase("no")) {
                    // Append a count to the file name
                    name = name.replaceFirst("\\.", " (" + counter + ").");
                    file = new File(location, name);
                    counter++;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }

            // Create the file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }
            URL downUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) downUrl.openConnection();
            //downloading the URL 
            conn.setRequestMethod("GET");
            int responseNo = conn.getResponseCode();
            //it is the status code from HTTPS
            if (responseNo == HttpURLConnection.HTTP_OK) {
                InputStream input = conn.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int byteRead;
                while ((byteRead = input.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, byteRead);
                }
                fileOutputStream.close();
                input.close();
                System.out.println("File downloaded successfully to: " + file.getAbsolutePath());
                //i found getAbsolutePath to declare the location of the file.
            } else {
                System.out.println("Failed to download file. Response code: " + responseNo);
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}