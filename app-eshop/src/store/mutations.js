
// 提交 mutations是更改Vuex状态的唯一合法方法
export const changetitle = (state, param) => {
  console.log(" mutations:{}",param);
  state.title = param // 把方法传递过来的参数，赋值给state中的resturantName
}


