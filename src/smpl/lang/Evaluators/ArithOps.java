package smpl.lang.Evaluators;

public enum ArithOps implements Operators<Double, Double> {
     
    ADD("+") {
         @Override
         public Double apply(Double arg1, Double arg2) {
             return arg1 + arg2;
         }
     },

     SUB("-") {
        @Override
        public Double apply(Double arg1, Double arg2) {
            return arg1 - arg2;
        }
     },

     DIV("/") {
         @Override
         public Double apply(Double arg1, Double arg2) {
             return arg1 / arg2;
         }
     },

     MUL("*") {
         @Override
         public Double apply(Double arg1, Double arg2) {
             return arg1 * arg2;
         }
     },

     MOD("%") {
         @Override
         public Double apply(Double arg1, Double arg2) {
             return arg1 % arg2;
         }
     };

     String symbol;

    ArithOps(String symbol) {
         this.symbol =symbol;
    }



    @Override
    public String getSymbol() {
        return symbol;
    }
}
