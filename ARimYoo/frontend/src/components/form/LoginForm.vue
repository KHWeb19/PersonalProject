<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>I D</td>
          <td><input class="underline" type="text" v-model="id"></td>
        </tr>
        <br/>
        <tr>
          <td>PASSWORD</td>
          <td><input class="underline" type="password" v-model="pw"></td>
        </tr>
      </table>

    </form>
  </v-container>
</template>

<script>

export default {
  name: "LoginForm",
  data () {
    return {
      id: '',
      pw: ''
    }
  },
  methods: {
    onSubmit () {
      const { id, pw } = this
      this.$emit('submit', { id, pw })
    }
  }
}

</script>

<style scoped>

input.underline {
  border-bottom:solid 2px;
  margin-left:1px;
}
td{
  font-weight: bold;
  text-align: center;
  padding-right:10px;
}
</style>