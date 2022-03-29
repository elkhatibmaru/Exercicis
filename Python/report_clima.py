import requests
from pprint import pprint

API_KEY="Introduiex una Api KEY:"

latitut = input("Introdueix una latitud: ")
longitud = input("Introdueix una longitud: ")

base_url = "http://api.openweathermap.org/data/2.5/weather?lat="+latitut+"&lon="+longitud+"appid="+API_KEY

report_clima = requests.get(base_url).json()

pprint(report_clima)
