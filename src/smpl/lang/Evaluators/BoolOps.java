package smpl.lang.Evaluators;

public enum BoolOps implements Operators<Double, Boolean> {
    
    GT(">") {
        @Override
        public Boolean apply(Double arg1, Double arg2) {
            return arg1 > arg2;
        }
    },


    LT("<") {
        @Override
        public Boolean apply(Double arg1, Double arg2) {
            return arg1 < arg2;
        }
    },


    EQ("==") {
        @Override
        public Boolean apply(Double arg1, Double arg2) {
            return arg1 == arg2;
        }
    }, 

    GTE(">=") {
        @Override
        public Boolean apply(Double arg1, Double arg2) {
            return arg1 >= arg2;
        }
    }, 

    LTE("<=") {
        @Override
        public Boolean apply(Double arg1, Double arg2) {
            return arg1 <= arg2;
        }
    };

    
    String symbol;

    BoolOps(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
