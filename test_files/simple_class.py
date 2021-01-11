from pyScaly_lib import *
print("This is the Python code!")

class A:
    def foo(self):
        x = 1
        def bar():
            y = 1
            def alpha():
                return x + y
            print(y)
        return bar
