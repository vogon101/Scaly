from pyScaly_lib import *
print("This is the Python code!")

class A:
    def foo(self, x):
        self.thing = 100
        def bar():
            y = 1
            def alpha(gamma):
                return x + y + self.thing + gamma
            print(y)
        return bar
