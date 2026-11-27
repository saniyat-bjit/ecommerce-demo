import os
import sys
import tempfile
import unittest

sys.path.insert(0, os.path.join(os.path.dirname(__file__), ".."))

import orders


class RunTest(unittest.TestCase):
    def test_shell_metacharacters_are_not_interpreted(self):
        with tempfile.TemporaryDirectory() as tmp:
            marker = os.path.join(tmp, "injected")
            orders.run("echo order; touch " + marker)
            self.assertFalse(os.path.exists(marker), "a shell ran the injected command")

    def test_runs_command_and_returns_exit_code(self):
        self.assertEqual(orders.run("true"), 0)
        self.assertEqual(orders.run("false"), 1)

    def test_accepts_argument_list(self):
        with tempfile.TemporaryDirectory() as tmp:
            target = os.path.join(tmp, "with space")
            self.assertEqual(orders.run(["touch", target]), 0)
            self.assertTrue(os.path.exists(target))


if __name__ == "__main__":
    unittest.main()
