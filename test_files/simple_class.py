from pyScaly_lib import *
print("This is the Python code!")

# class Main:
#     def main():
#         i = 0
#         while(i.__lt__(10)):
#             print(i)
#             i = i.__add__(1)
#
# class A:
#     def __init__(self):
#         print("A")
#
# class B(A, Main):
#     def __init__(self):
#         super().__init__()
#         print("B")
#
#
# class C(B):
#     def __init__(self):
#         super().__init__()
#         print("C")

class A:
    def __init__(self):
        print("hi")

    def foo():
        print("A")

class B(A):
    def __init__(self):
        A.__init__(self)


# class A:
#     def foo():
#         print("A")
# class B(A):
#     def __init__(self):
#         A.__init__(self)
#         print("B init")
#
#     def foo():
#         print("B")
# class C(B):
#     def __init__(self):
#         B.__init__(self)

# class FibGen:
#     def __init__(self):
#         self.thing = 100
#
#     def fib(self, n):
#         if (n.__lt__(2)): return 1
#         else: return self.fib(n.__sub__(1)).__add__(self.fib(n.__sub__(2)))
#
#     def foo():
#         x = 10
#         print(x)