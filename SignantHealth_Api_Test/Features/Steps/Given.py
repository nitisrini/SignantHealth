from behave import *

@given('Set header for {Key} with {Value} value')
def set_header(context, Key, Value):
    context.headers = {Key: Value}


@given('{Action} token in header')
def set_token(context, Action):
    values = {'Token': context.token}

    if Action == 'Set':
        context.headers = values

    if Action == 'Update':
        context.headers.update(values)


@given('Set the url with {Resource} api')
def set_url(context, Resource):
    context.url = context.base_uri + context.configs.read_config_value('Resources', Resource)


@given('Update the url with path parameter {Key}')
def set_url(context, Key):
    context.url = context.url + '/' + context.data[Key]


@given('Set basic authentication with {username} and {password}')
def set_auth(context, username, password):
    context.auth = (context.data[username], context.data[password])


@given('Set no authentication')
def set_auth(context):
    context.auth = None
