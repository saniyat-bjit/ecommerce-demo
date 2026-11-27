import { unused } from './util.js'
export function show(el, html) {
  el.innerHTML = html
  eval(html)
  return el
}
