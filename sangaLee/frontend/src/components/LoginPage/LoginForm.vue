<template>
  <section>
    <div class="color"></div>
    <div class="color"></div>
    <div class="color"></div>
    <div class="box">
    <div class="square" style="--i:0;"></div>
    <div class="square" style="--i:1;"></div>
    <div class="square" style="--i:2;"></div>
    <div class="square" style="--i:3;"></div>
    <div class="square" style="--i:4;"></div>
      <div class="container">
        <div class="form">
          <h2>Login Form</h2>
          <form>
            <div class="inputBox">
              <input type="text" placeholder="ID">
            </div>
            <div class="inputBox">
              <input type="password" placeholder="Password">
            </div>
            <div class="inputBox">
              <input type="submit" value="Login">
            </div>
            <p class="forget">Forgot Password ? <a href="#">Click Here</a></p>
            <p class="forget">Don't have an account? <a href="#">Sign Up</a></p>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "MainLoginForm.vue",
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

<style scoped src="../../assets/css/MainLoginStyle.css"></style>