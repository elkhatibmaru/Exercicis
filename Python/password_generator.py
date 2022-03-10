from operator import le
import random
from ssl import _PasswordType

print("--Generador de Contrasenyes--")

caracters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@%^&*().,?012345678'

numPassword = input("Numero de contrasenyes a generar: ")
numPassword = int(numPassword)

lengthPassword = input("Llargada de la contrasenya: ")
lengthPassword = int(lengthPassword)

print("\nAqui tens les teves contrasenyes:")

for pw in range(numPassword):
    contrasenyes = ''
    for c in range(lengthPassword):
        contrasenyes += random.choice(caracters)
    print(contrasenyes)