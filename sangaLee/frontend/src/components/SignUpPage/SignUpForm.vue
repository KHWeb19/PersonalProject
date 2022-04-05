<template>
  <section>
    <div class="box">
      <div class="container">
        <div class="form">
          <h2>회원가입</h2>
          <form>
            <div class="inputBox">
              <input type="text" placeholder="ID">
            </div>
            <div class="inputBox">
              <input type="submit" value="중복확인">
            </div>
            <div class="inputBox">
              <input type="password" placeholder="Password">
            </div>
            <div class="inputBox">
              <input type="submit" value="가입하기">
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
/*
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
}*/
</script>

<style scoped src="../../assets/css/SignUpStyle.css"></style>