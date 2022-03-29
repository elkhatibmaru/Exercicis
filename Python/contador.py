import time

def countdown(t):
    while t:
        mins,secs = divmod(t,60)
        timer = '{:00}:{00}'.format(mins,secs)
        print(timer,end="\r")
        time.sleep(1)
        t -= 1
    print("Contador complert!")

temps = input("Introdueix el temps en segons: ")

countdown(int(temps))