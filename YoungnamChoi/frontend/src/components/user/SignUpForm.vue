<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <div class="회원가입중하단" align="center">
        <b-form style="width: 400px" @submit="onSubmit">
          <b-form-group id="input-group-1" label="ID:">
            <b-form-input
              v-model="id"
              type="text"
              placeholder="Enter ID"
              required
              size="lg"
            ></b-form-input>
          </b-form-group>

          <br />

          <b-form-group label="Passord:">
            <b-form-input
              v-model="pw"
              aria-describedby="input-live-feedback"
              type="password"
              placeholder="Enter Passord"
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

          <!-- <br>
            <v-btn type="submit" dark block large>가입하기</v-btn> -->
        </b-form>

        <br />
        <v-btn color="blue" dark type="submit" large style="width: 400px"
          >가입하기</v-btn
        >
      </div>
    </form>
  </v-container>
</template>

<script>
export default {
  name: "SignUpForm.vue",
  data() {
    return {
      id: "",
      pw: "",
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
