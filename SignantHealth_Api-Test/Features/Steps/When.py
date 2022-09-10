from behave import *
import requests


@when('Make {Method} call and retrieve response')
def make_call(context, Method):

    if Method == 'GET':
        req_payload = None

    if Method == 'POST':
        req_payload = context.data

    if Method == 'PUT':
        req_payload = context.update_data

    context.resp = requests.request(method=Method, url=context.url, auth=context.auth, headers=context.headers, json=req_payload)
