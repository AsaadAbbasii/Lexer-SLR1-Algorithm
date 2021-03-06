enum TOKEN_NAME {
   RO,OO,AO,
   ID,SL,IN,
   INT,CHAR,STRING,IF,ELSE,DO,WHILE,
   EOF;
}

public class token {
   
   public TOKEN_NAME tokenName;
   public String lexeme,attribValue; //attribute value according to lexeme table
   public int attribCounter = -1; //attribute value according to symbol table
   
   public int lineNumber = -1; //line number this token is at

   public int position = -1;
   
   public token() {} //intiializer
   public token(String lexeme,int lineNumber) { this.lexeme = lexeme; this.lineNumber = lineNumber;} //invalid tokens and comments
   public token(TOKEN_NAME tokenName , String lexeme , String attribValue) { //normal tokens
      this.tokenName = tokenName;
      this.lexeme = lexeme;
      this.attribValue = attribValue;
   }
   public token(TOKEN_NAME tokenName , String lexeme , int attribCounter) { //symbol tokens
      this.tokenName = tokenName;
      this.lexeme = lexeme;
      this.attribCounter = attribCounter;
   }

   public void print() {
      if(attribCounter < 0) System.out.println(lexeme +  "  \t  "  + tokenName.toString().toLowerCase() + "  \t  "  + attribValue.toLowerCase()); //it's a token with which is not in symbol table
      else System.out.println(lexeme + "  \t  " + tokenName.toString().toLowerCase()  + "  \t  "   + attribCounter); //it's a token which is in symbol table
   }
}