import sys
from pathlib import Path


sys.path.append(Path(__file__).parent.parent)

from CustomLibraries.UserDetails import RandomUserDetails
from Utils.Configs import ReadConfigs


def before_all(context):
    context.api_dict = {}
    context.configs = ReadConfigs()

    context.base_uri = context.configs.read_config_value('Base', 'Uri')


def before_scenario(context, scenario):
    context.url = None
    context.auth = None
    context.headers = None

    random = RandomUserDetails()
    context.data = random.generate_random_user_details()

    if 'update_user' in scenario.tags:
        data = random.generate_random_user_details()
        data.pop('username')
        data.pop('password')
        context.update_data = data


def  after_scenario(context, scenario):
    context.data.clear()

