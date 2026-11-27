import shlex
import subprocess


def total(items=None):
    if items is None:
        items = []
    try:
        return sum(i.price for i in items)
    except:
        return 0


def run(cmd):
    args = shlex.split(cmd) if isinstance(cmd, str) else list(cmd)
    return subprocess.call(args)
