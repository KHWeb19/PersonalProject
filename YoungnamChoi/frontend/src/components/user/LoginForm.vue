<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <div class="login" align="center">
        <b-form style="width: 400px" @submit="onSubmit">
          <b-form-group id="input-group-1" label="" label-for="input-1">
            <b-form-input
              id="input-1"
              v-model="id"
              type="email"
              placeholder="Enter Id"
              required
              size="lg"
            ></b-form-input>
          </b-form-group>

          <br />

          <b-form-group id="input-group-2" label="" label-for="input-2">
            <b-form-input
              id="input-2"
              v-model="pw"
              aria-describedby="input-live-feedback"
              type="password"
              placeholder="Enter password"
              required
              size="lg"
            ></b-form-input>

            <b-form-invalid-feedback id="input-live-feedback">
              Enter at least 8 letters
            </b-form-invalid-feedback>
          </b-form-group>

          <b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
            <b-form-checkbox-group
              id="checkboxes-4"
              :aria-describedby="ariaDescribedby"
            >
            </b-form-checkbox-group>
          </b-form-group>
        </b-form>
        <br />
        <v-btn color="blue" dark type="submit" large style="width: 400px"
          >로그인</v-btn
        >
        <br />
        <br />
        <router-link
          style="text-decoration: none; color: black"
          :to="{ name: 'SignUpPage' }"
        >
          <h6>회원 가입</h6>
        </router-link>
      </div>
    </form>
  </v-container>
</template>
<script>
// @ is an alias to /src

export default {
  name: "LoginForm.vue",
  data() {
    return {
      id: "",
      pe: "",
    };
  },
  methods: {
    onSubmit() {
      const { id, pw } = this;
      this.$emit("submit", { id, pw });
    },
  },
};
</script>
<style scoped>
.로그인중하단 {
  padding: 0px 0px 80px 0px;
}
</style>
