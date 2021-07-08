import requests
import pandas as pd
import xmltodict
import json

b = ['081660','025980','025980','025980','025980','025980','025980','025980','025980','025980','025980']
count = '2500'


def a(stockCode, count):
    url = f'https://fchart.stock.naver.com/sise.nhn?symbol={stockCode}&timeframe=day&count={count}&requestType=0'

    rs = requests.get(url)
    dt = xmltodict.parse(rs.text)
    js = json.dumps(dt, indent=4)
    js = json.loads(js)

    data = pd.json_normalize(js['protocol']['chartdata']['item'])
    df = data['@data'].str.split('|', expand=True)
    df.columns = ['date', 'open', 'high', 'low', 'close', 'Volume']
    df.to_csv('{}.csv'.format(stockCode))

for i in b:
    a(i, 2500)
