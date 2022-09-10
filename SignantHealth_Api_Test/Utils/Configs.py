import configparser
from pathlib import Path


class ReadConfigs:
    config = None

    def __init__(self):
        self.config = configparser.ConfigParser()
        self.config.read(Path.joinpath(Path(__file__).parent, 'Properties.ini'))

    def read_config_value(self, section, key):
        return self.config[section][key]
