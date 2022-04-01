<template>
  <v-container class="spacing-playground pa-16">
    <login-page-form></login-page-form>
  </v-container>
</template>

<script>
import LoginPageForm from "@/components/login/LoginPageForm";
export default {
  name: "LoginPage",
  components: {LoginPageForm}
}
</script>

<style scoped>

</style>