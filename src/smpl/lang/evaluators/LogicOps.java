package smpl.lang.evaluators;

public enum LogicOps implements Operators<Boolean, Boolean> {
    

    AND("AND") {
        @Override
        public Boolean apply(Boolean arg1, Boolean arg2) {
            return arg1 && arg2;
        }
    },


    OR("OR") {
        @Override
        public Boolean apply(Boolean arg1, Boolean arg2) {
            return arg1 || arg2;
        }
    },


    NOT("NOT") {
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
