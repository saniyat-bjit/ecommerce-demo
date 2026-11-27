import { unused } from './util.js'
export function show(el, html) {
  if (html == null) { debugger }
  el.innerHTML = html
  eval(html)
  return el
}
