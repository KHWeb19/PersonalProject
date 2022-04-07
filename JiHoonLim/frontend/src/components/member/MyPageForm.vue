<template>
  <div>
    <v-container>
      <v-row justify="center">
        <v-col>
          <v-card>
            <v-tabs
              background-color="orange lighten-1"
              color="white"
              centered
              height="70px"
              fixed-tabs
            >
              <v-tab style="font-size: 30px">레시피 보관함</v-tab>
              <v-tab style="font-size: 30px">회원 정보 수정</v-tab>
            </v-tabs>
            <v-tabs-items>
              <v-form> </v-form>
            </v-tabs-items>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "MyPageForm.vue",
};
</script>

<style scoped></style>
