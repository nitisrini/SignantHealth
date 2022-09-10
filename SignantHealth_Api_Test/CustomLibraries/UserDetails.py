from faker import Faker


class RandomUserDetails:
    fake = None

    def __init__(self):
        self.fake = Faker()

    def generate_random_user_details(self):
        firstname = self.fake.first_name()
        lastname = self.fake.last_name()
        phone = self.fake.phone_number()
        username = firstname + str(self.fake.random_int(max=9999))
        password = self.fake.password(length=8)

        user_details = {
            'username': username,
            'password': password,
            'firstname': firstname,
            'lastname': lastname,
            'phone': phone
        }

        return user_details
