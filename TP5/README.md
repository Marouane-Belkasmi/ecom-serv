# Angular - Json Server web application

this is a simple web application that uses Angular and Json Server to create a simple web application that can be used to create, read, update and delete data from a json file.


## Installation

clone the repository and run the following commands:

```bash
npm install
```

make sure you have json-server installed globally, if not run the following command:

```bash
npm install -g json-server
```

## Usage

1- make sure you have data/db.json file in the root directory of the project, if not create one and add the necessary data.

2- to run the application, run first the json-server using the following command:

```bash
json-server --watch data/db.json --port 8080
```

3- then run the angular application using the following command:

```bash
ng serve
```

4- open your browser and go to http://localhost:4200/ to see the application running.


## screenshots

the first screenshot shows the login page, where the user can login using his username and password.


![1](https://github.com/Yahya-rabii/JEE/assets/92509001/c5a6e2a4-f5ec-4c5e-848a-9d919bbd949d)


the second screenshot shows the home page, where the user can see the navigation bar and the logout button next to its username.
![2](https://github.com/Yahya-rabii/JEE/assets/92509001/6042a5bf-7f0b-4621-a481-feda2c253651)



the third screenshot shows the products page, where the user can see the list of products and search for a specific product using the search bar.

![3](https://github.com/Yahya-rabii/JEE/assets/92509001/1562c677-b39b-4b85-a89f-9c29e6dbd37d)


the fourth screenshot shows the add product page, where the user can't add a product unless he is an admin.

![4](https://github.com/Yahya-rabii/JEE/assets/92509001/821e27a5-dc4f-4314-b846-a93e1adc8487)


the last screenshot shows that for an admin user, the add product component is available and he can add a product to the list of products.


![5](https://github.com/Yahya-rabii/JEE/assets/92509001/95c7ae18-4aa7-405d-9766-9a1378073262)




