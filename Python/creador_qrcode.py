import qrcode

missatge = input("Introdueix un missatge: ")

img = qrcode.make(missatge)
img.save("imatges_qr/qrcode.jpg")
print("S'ha guardat la imatge")


