<template>
  <section>
    <div class="color"></div>
    <div class="color"></div>
    <div class="color"></div>
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

<style>
  @import url("./assets/css/MainLoginStyle.css");
</style>