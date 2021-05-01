class ScalyObject(object):
    def toString(self):
        return "ScalyObject @ " + str(super.__str__(self))

    def __str__(self):
        return self.toString()

    def __eq__(self, obj):
        return self is obj

    def equals(self, obj):
        return self.__eq__(obj)


    def isInstanceOf(self, cls):
        return isinstance(self, cls)


    #TODO: isInstanceOf?