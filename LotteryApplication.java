import java.util.Scanner;     // Needed for Scanner class

/**
   Alex Waters id# 23598844
   1st project CSC 210 - 1701
   Comp. Prog. II 5:20PM - 7:35PM
   Fiterman Hall 906 
   Instructor: Alam Miah
   RainFall Test Program Chapter 7 #10
*/

public class LotteryApplication
{
   public static void main(String[] args)
   {
      final int PICK_FIVE = 5;   // Number of picks for lotto
      int totalCorrect;          // Total of user picks correct.
      int[] lottoNumbers = new int[PICK_FIVE]; // Users array
      int[] gotRight;            // Stores matching numbers in 
                                 // array.
      
      // Create lottery object.
      Lottery lotto = new Lottery();
      
      // Welcome user to program.
      welcome();
      
      // Get users lottery numbers and
      // validate user input.
      getUsersPick(lottoNumbers);
      
      // Pass lottoNumbers to setUsersLotteryPicks
      // method in lottery class.
      lotto.setUsersLotteryPicks(lottoNumbers);
      
      // Check if users picks match random 
      // number picks from lottery class
      // storing results in gotRight variable.
      gotRight = matchingNumbers(lotto);
      
      // Display pick five lottery numbers
      // from class.
      displayLotteryNumbers(lotto); 
      
      // Display user Numbers picked.
      displayUsersNumbers(lotto);
      
      // Display which Numbers match.
      totalCorrect = displayNumbersCorrect(gotRight); 
      System.out.println("\nYou Got : " + totalCorrect +
                         " Correct\n"); 
      
      // If matching numbers is equal to
      // 5 display grandPrizeWinner method.
      if(totalCorrect == 5)
         grandPrizeWinner();
      else
         loser();    // Not a winner.
         
      // Exit system and display GoodBye.
      goodBye(); 
      System.exit(0);      
   }
   
   /**
      welcome method greets the user and 
      displays instructions.
   */
      
   public static void welcome()
   {
      System.out.println("--------------------------");
      System.out.println("\n\tLottery Application");
      System.out.println("\n--------------------------");
      System.out.println("\n\t\t Pick 5 Numbers\n\n\t\t\t  0 - 9");
      System.out.println("\n\t\tFor A Chance to\n\n\t\t\t\tWIN\n");
      System.out.println("\t$1,000,000,000,000,000\n\t\t\tCASH MONEY\n");
   
   }
      
   /**
      getUsersPick method gets user keyboard 
      input and stores in lottoNumbers array.
      @param lottoNumbers Pass to get length.
      @return Users lottoNumbers picks.
   */
      
   public static int[] getUsersPick(int[] lottoNumbers)
   {
      // Create Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
         
      // Get users input for all 5 numbers
      // and store in lottoNumbers array.
      for(int index = 0; index < lottoNumbers.length; index++)
      {
         System.out.print("Enter Pick #" + (index + 1) + ": ");
         lottoNumbers[index] = keyboard.nextInt();
            
         // Use inputValidation method to check
         // for correct input 0 - 9.
         if(inputValidation(lottoNumbers[index]))
            --index; // Go back an index if true.
      }
         
      return lottoNumbers;
   }
      
   /**
      inputValidation method checks user
      input for negative numbers.
      @param num LottoNumbers in loop.
      @return Validation true if negative 
              number.
   */
      
   public static boolean inputValidation(int num)
   {
      boolean validation;   // Flag variable
         
      // Validation is True if numbers are
      // negative or greater than 9.
      if(num < 0 || num > 9)
      {
         // Error message.
         System.out.println("----------------------\n");
         System.out.println("\t\t\tERROR:\n\t\tEntry MUST Be ");
         System.out.println("\t\t\t0 - 9");
         System.out.println("\t\t Try again\n");
         System.out.println("----------------------\n");
         validation = true;
      }
      else
         validation = false;
         
      return validation;
   } 
      
   /**
      matchingNumbers method gets Lottery object
      and compares random picks to users picks.
      @param Lotter lotto Pass lottery object.
      @return The number of numbers that matched.
   */
      
   public static int[] matchingNumbers(Lottery lotto)
   {
      int[] match;   // Holds mathching numbers
      
      // Assign lotteryNumbers and user 
      // numbers to variables.
      int[] winningNumbers = lotto.getLotteryNumbers(); 
      int[] usersNumbers = lotto.getUsersLotteryPicks();   
      
      match = new int[winningNumbers.length];   // Assign length
      
      // Compare Numbers and if match store
      // in match array.
      for(int index = 0; index < winningNumbers.length; index++)
      {
         if(winningNumbers[index] == usersNumbers[index])
            match[index] = winningNumbers[index];
         else
            match[index] = -1; // Make less than zero
                               // so elements wont
                               // display.
      }
      
      return match;  
   }
   
   /**
      displayLotteryNumbers method shows lottery
      numbers from lotter class.
      @param Lottery lotto Pass Lottery object.
   */
   
   public static void displayLotteryNumbers(Lottery lotto)
   {
      // Assign lottery numbers to numbers.
      int[] numbers = lotto.getLotteryNumbers();
      
      // Display numbers using expanded
      // for loop.
      System.out.println("\n***********************\n");
      System.out.println("\tPICK FIVE NUMBERS");
      System.out.println("\n***********************");
      for(int n: numbers)
         System.out.printf(" %d  ", n);   // Percision
      System.out.println("\n**********************\n");
   } 
   
   /**
      displayUsersNumbers method shows
      the users picks.
      @param lotto Pass lottery object.
   */
   
   public static void displayUsersNumbers(Lottery lotto)
   {
      // Assign users lottery numbers to numbers.
      int[] numbers = lotto.getUsersLotteryPicks();
      
      // Display numbers using expanded
      // for loop.
      System.out.println("----------------------");
      System.out.println("\t\tYou Picked");
      System.out.println("----------------------");
      for(int n: numbers)
         System.out.printf(" %d  ", n);
      System.out.println("\n----------------------\n");

   } 
   
   /**
      displayNumbersCorrect method shows
      matching numbers.
      @param correct Total picks that matched.
      @return Total number of correct picks.
   */
   
   public static int displayNumbersCorrect(int[] correct)
   {
      int picks = 0; // Accumulator
      
      // Display the numbers that
      // match in loop.
      System.out.println("Your Matching Numbers:\n");
      for(int index = 0; index < correct.length; index++)
      {
         if(correct[index] < 0)
            System.out.print(" ");
         else
         {
            System.out.print(" " + correct[index] + " "); 
            picks += 1;
         }
      }
      System.out.println();
      
      return picks;  // Total picks correct
   }
      
   /**
      grandPrizeWinner method congratulates 
      user for getting all lotto numbers 
      correct.
   */
      
   public static void grandPrizeWinner()
   {
      System.out.println("\t\t\tWoW!!!\n\t\tYou Won the\n");
      System.out.println("\t  Pick Five Lottery");
      System.out.println("\t$1,000,000,000,000,000\n" +
                         "\t\tCASH MONEY\n");
   }
      
   /**
      loser method displays to user better 
      luck next time.
   */
      
   public static void loser()
   {
      System.out.println("\n\t  -Luck-Luck-Luck-\n\tis not on your Side");
      System.out.println("\n\tCross your FINGERS\n\t\t  Next Time");
   }
      
   /**
      goodBye method ends program and displays
      to the user hope to see you again.
   */
      
   public static void goodBye()
   {
      System.out.println("\n\tThanks for playing\n");
      System.out.println("\t\t-Pick Five-\n");
      System.out.println("  Next Lotto will be in\n" +
                            "\t\t*Two Days*\n");
      System.out.println("\t See ya Soon!!!");   
   }
}
      
      