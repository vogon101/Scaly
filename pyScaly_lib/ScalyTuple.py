class ScalyTuple(tuple):
    @property
    def _1(self): return self[0]

    @property
    def _2(self): return self[1]

    @property
    def _3(self): return self[2]

    @property
    def _4(self): return self[3]

    @property
    def _5(self): return self[4]

    @property
    def _6(self): return self[5]

    @property
    def _7(self): return self[6]

    @property
    def _8(self): return self[7]

    @property
    def _9(self): return self[8]

    @property
    def _10(self): return self[9]

    @property
    def _11(self): return self[10]

    @property
    def _12(self): return self[11]

    @property
    def _13(self): return self[12]

    @property
    def _14(self): return self[13]

    @property
    def _15(self): return self[14]

    @property
    def _16(self): return self[15]

    @property
    def _17(self): return self[16]

    @property
    def _18(self): return self[17]

    @property
    def _19(self): return self[18]

    @property
    def _20(self): return self[19]

    @property
    def _21(self): return self[20]


    def __new__(cls, elems):
        return tuple.__new__(cls, elems)

    #TODO: This could work for all value types
    #   It is inefficient but could be enough for this project
    #   Would allow them to have toString methods etc.
    def toString(self):
        return self.__str__()