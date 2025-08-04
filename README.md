# Selenium Java Practice  
*A beginner’s automation testing practice project using Selenium and Java*
## Introduction  
Hi there! This is my very first repository for learning Automation Testing.  
The goal of this project is to:  
- Get familiar with Selenium WebDriver.
- Write basic test scripts using Java.
- Practice using tools like IntelliJ, Maven, and WebDriverManager.
- Build a basic understanding of how browser automation works.
## Technologies Used  
- Java (basic level).
- Selenium WebDriver.
- JUnit 5 for writing test cases.
- WebDriverManager to manage browser drivers.
- Maven for dependency management and running tests.
## How to Run This Project  
1. Make sure you have Java (8 or higher) and Maven installed.  
2. Clone the repository:  
<pre> bash  
  git clone https://github.com/Bunny-Ty/selenium-java.git  
  cd selenium-java </pre>  
3. Run the tests:  
<pre> bash  
  mvn test </pre>  
## Folder Structure  
<pre> bash  
selenium-java/
├── .github/                   
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/   
│   └── test/
│       └── java/
│           ├── browser/       
│           ├── calculator/    
│           ├── common/        
│           ├── demo/          
│           ├── exercise/      
│           ├── heroku/       
│           ├── pages/         
│           └── utils/         
├── .gitignore                 
├── login-testplan.xml       
├── pom.xml                   
├── testng.xml </pre>  
## What I’ve Learned So Far  
- How to launch a browser with Selenium.
- How to locate and interact with web elements using By.id, By.name, By.xpath, etc.
- Writing a simple test to verify page title.
- Organizing tests using JUnit.
## Sample Test Code  
<pre> java  
  @Test
void testOpenGoogle() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    assertEquals("Google", driver.getTitle());
    driver.quit();
} </pre>  
## Next Learning Goals  
- Write more test cases with validations.
- Learn how to generate test reports.
- Try running tests on multiple browsers (Chrome, Firefox, Edge…).
