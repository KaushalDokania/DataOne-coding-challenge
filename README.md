# DataOne-coding-challenge
*This repository contains the solution to the coding challenge given by DataOne Innovation Labs for the hiring process for the Software Engineer post.*

## Executing the program

### Fetching the source code
* First of all **clone** this repopsitory in your PC in some directory say `E:\code`

### Compiling the program
* Double click on `compile.bat` in `E:\code` directory to compile the program

								or
Open command prompt and change the directory to `E:\Code` by typing the following
````
> cd E:\code
````
* Run the following command in command prompt to compile the program
````
E:\Code> javac CSVFileRead.java
````

### Running the program
* Double click on `run.bat` to compile the program with one of the sample input case
* To run the program with different input use the following syntax
````
java CSVFileRead <CSV-price-file> <custom input seperated by spaces>
````
* CSV-price-file is the data file with extension `.csv`, which contains all the shop/product pricing.*
for e.g.
````
E:\Code> java CSVFileRead data.csv scissor powder_puff cotton_balls
````
Note: If the `CSV-price-file` is in other directory please use the full path with file name, otherwise it will give error.