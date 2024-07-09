# eBay-Mobile-Phone-Search-Test
Description
This project is a comprehensive automation suite for testing the search and purchase functionality of mobile phones on eBay using Selenium WebDriver and TestNG. The suite includes tests for navigating to the eBay website, searching for mobile phones, selecting a product, configuring product attributes (such as color, plug, size, carrier, memory, network, and model), adding the product to the cart, and proceeding to checkout in guest mode. The project is structured with a Maven build and contains organized test classes and a TestNG XML configuration for orderly test execution.

Features
Setup and Teardown: Initialize and maximize the browser window, navigate to eBay, and clean up after tests.
Navigation and Search: Navigate to eBay, select the mobile phones category, search for mobile phones, and choose from search results.
Product Selection: Extract product name, price, and quantity; select various product attributes such as color, plug, size, carrier, memory, network, and model.
Cart and Checkout: Add the product to the cart, handle checkout, and proceed as a guest user.
Assertions: Validate URLs, search results, product details, and checkout information.
