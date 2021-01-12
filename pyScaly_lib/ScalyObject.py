class ScalyObject(object):
    def toString(self):
        return "ScalyObject @ " + str(super.__str__(self))

    def __str__(self):
        return self.toString()

    def equals(self, obj):
        return self.__eq__(obj)

    #TODO: isInstanceOf?