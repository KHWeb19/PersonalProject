<template>
  <div>
    <v-footer dark padless style="display: block">
      <v-card flat tile class="orange lighten-1 white--text text-center">
        <v-container style="width: 1240px">
          <v-row>
            <v-col>
              <div
                style="display: flex; justify-content: center"
                class="mt-5 mb-5"
              >
                <div class="mx-auto" style="display: flex">
                  <v-img
                    :src="require('@/assets/img/memberCount.png')"
                    max-width="150px"
                    max-height="150px"
                  />
                  <div class="countWrap">
                    <div class="titText">총 회원수</div>
                    <div class="countText">{{ registerMembers.length }} 명</div>
                  </div>
                </div>
                <div class="mx-auto" style="display: flex">
                  <v-img
                    :src="require('@/assets/img/foodCount.png')"
                    max-width="150px"
                    max-height="150px"
                  />
                  <div class="countWrap">
                    <div class="titText">총 레시피수</div>
                    <div class="countText">{{ foodBoards.length }} 개</div>
                  </div>
                </div>
              </div>

              <v-divider></v-divider>

              <v-card-text class="white--text">
                {{ new Date().getFullYear() }} — <strong>Vuetify</strong>
              </v-card-text>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </v-footer>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
export default {
  computed: {
    ...mapState(["foodBoards", "registerMembers"]),
  },
  mounted() {
    this.fetchFoodBoardList();
    this.fetchRegisterMembers();
  },
  methods: {
    ...mapActions(["fetchFoodBoardList", "fetchRegisterMembers"]),
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");

.titText {
  font-size: 32px;
}
.countText {
  color: #e2e2e2;
  display: block;
  font-size: 24px;
  font-weight: normal;
  margin-top: 4px;
}

.countWrap {
  text-align: center;
  margin-top: 30px;
  margin-left: 40px;
}
</style>
