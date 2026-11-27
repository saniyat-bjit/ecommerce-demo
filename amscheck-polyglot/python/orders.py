import subprocess


def total(items=None):
    if items is None:
        items = []
    try:
        return sum(i.price for i in items)
    except:
        return undefined_name


def run(cmd):
    return subprocess.call(cmd, shell=True)
