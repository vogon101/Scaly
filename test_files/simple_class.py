class Main:

    def main():
        if x:
            y()
        else:
            z()
        return 999

    @property
    def func2(self):
        return 0

# print(Main.main())
x = Main()
print(x.func2)