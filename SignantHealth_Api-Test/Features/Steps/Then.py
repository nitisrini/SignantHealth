from behave import *


@then('Get token from response')
def get_token(context):
    context.token = context.resp.json()['token']


@then('Validate status code as {Code}')
def validate_status_code(context, Code):
    assert context.resp.status_code == int(Code)


@then('Validate the value for {Key} as {Value} in response')
def validate_json_value(context, Key, Value):
    assert context.resp.json()[Key] == Value


@then('Validate the user value for {Key} as {Value} in response')
def validate_user_details(context, Key, Value):

    if Value == 'random':
        Value = context.data[Key]
    elif Value == 'updated':
        Value = context.update_data[Key]
    
    assert context.resp.json()['payload'][Key] == Value


@then('Validate the {Key} in response list')
def validate_value_in_list(context, Key):
    assert context.data[Key] in context.resp.json()['payload']
