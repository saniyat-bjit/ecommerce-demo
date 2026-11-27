import os
import sys
import unittest

sys.path.insert(0, os.path.join(os.path.dirname(__file__), ".."))

import orders


class Item:
    def __init__(self, price):
        self.price = price


class TotalTest(unittest.TestCase):
    def test_sums_item_prices(self):
        self.assertEqual(orders.total([Item(2), Item(3)]), 5)

    def test_no_items_is_zero(self):
        self.assertEqual(orders.total(), 0)

    def test_item_without_price_falls_back_to_zero(self):
        # Before the fix the except branch returned an undefined name and raised NameError.
        self.assertEqual(orders.total([object()]), 0)


if __name__ == "__main__":
    unittest.main()
