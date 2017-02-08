
# APIの叩き方

## データ作成

### 呼び出し方
```
curl -v  \
    -w '%{response_code}' \
     -H "Accept: application/json" \
    -H "Content-type: application/json" \
    -X POST \
    -d '{"value": "hogehoge"}' \
    http://localhost:18080/sample/api/create \
    | jq .
```

### レスポンス例
```
{
  "msg": "success.",
  "id": "ad8a0420-c032-11e6-8ce0-d644189456d1",
  "value": "hogehoge"
}
```

## データ取得

### 呼び出し方
```
curl -X GET http://localhost:18080/sample/api/get?id=ad8a0420-c032-11e6-8ce0-d644189456d1  | jq .
```

### レスポンス例
```
{
  "msg": "found.",
  "id": "ad8a0420-c032-11e6-8ce0-d644189456d1",
  "value": "hogehoge"
}
```
