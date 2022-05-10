<template>
  <v-app>
    <v-main>
      <router-view/>
        <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput></TodoInput>
    <TodoList></TodoList>
    <TodoFooter></TodoFooter>
  </div>
    </v-main>
  </v-app>
</template>


<script>
import TodoHeader from './components/Todo/TodoHeader.vue'
import TodoInput from './components/Todo/TodoInput.vue'
import TodoList from './components/Todo/TodoList.vue'
import TodoFooter from './components/Todo/TodoFooter.vue'
export default {
  name: 'App',
  components: {
    TodoHeader,
    TodoInput,
    TodoList,
    TodoFooter
  },
  data: () => ({
    //
  })
}; 
</script>

<style scoped>
body {
  text-align: center;
  background-color: #F6F6F6;
}
input {
  border-style: groove;
  width: 200px;
}
button {
  border-style: groove;
}
.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03);
}
</style>
