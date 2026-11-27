import shlex
import subprocess


def total(items=[]):
    try:
        return sum(i.price for i in items)
    except:
        return undefined_name


def run(cmd):
    args = shlex.split(cmd) if isinstance(cmd, str) else list(cmd)
    return subprocess.call(args)
