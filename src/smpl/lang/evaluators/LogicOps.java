package smpl.lang.evaluators;

public enum LogicOps implements Operators<Boolean, Boolean> {
    

    AND("and") {
        @Override
        public Boolean apply(Boolean arg1, Boolean arg2) {
            return arg1 && arg2;
        }
    },


    OR("or") {
        @Override
        public Boolean apply(Boolean arg1, Boolean arg2) {
            return arg1 || arg2;
        }
    },


    NOT("not") {
        @Override
        public Boolean apply(Boolean arg1, Boolean arg2) {
            return !arg1;
        }
    };


    String symbol;

    LogicOps(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
