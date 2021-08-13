# bookapp
Java application for quick book storage, update, access and total price calculation.
*   A client can use a REST call to put a book into the system providing its name, author, barcode, quantity, price per unit.
*   A client can use a REST call to retrieve book’s information from a system by providing its barcode.
*   A client can use a REST call to update any of its detail providing the barcode and updated field information.
*  A client can use a REST call to calculate the total price of specific books in the system given the barcode (including antique books and science journals).
*  A client can use a REST call to request a list of all barcodes for the books in stock grouped by quantity

Total price = Quantity * Price

