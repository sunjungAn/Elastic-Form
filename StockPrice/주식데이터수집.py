import requests
import pandas as pd
import xmltodict
import json

stockCode = '215000'
count = '250'
url = f'https://fchart.stock.naver.com/sise.nhn?symbol={stockCode}&timeframe=day&count={count}&requestType=0'

rs = requests.get(url)
dt = xmltodict.parse(rs.text)
js = json.dumps(dt, indent = 4)
js = json.loads(js)

data = pd.json_normalize(js['protocol']['chartdata']['item'])
df = data['@data'].str.split('|',expand = True)
df.columns = ['date','open','high','low','close','Volume']
df.to_csv("GolfZone.csv")
