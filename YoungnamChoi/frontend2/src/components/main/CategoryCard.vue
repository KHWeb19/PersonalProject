<template>
  <v-row justify="center" no-gutters>
    <v-col cols="2">
      <v-card class="mx-4" max-width="320">
        <v-img src="@/assets/imgs/한식.jpg" height="200px"></v-img>
        <v-spacer></v-spacer>
        <v-spacer></v-spacer>
        <v-card-title> 한식 </v-card-title>

        <v-card-actions>
          <v-btn color="orange lighten-2" text @click="feed"> Explore </v-btn>

          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-col>
    <v-col cols="2">
      <v-card class="mx-4" max-width="320" @click="feed">
        <v-img src="@/assets/imgs/양식.jpg" height="200px"></v-img>
        <v-spacer></v-spacer>
        <v-spacer></v-spacer>
        <v-card-title> 양식 </v-card-title>

        <v-card-actions>
          <v-btn color="orange lighten-2" text @click="feed"> Explore </v-btn>

          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-col>
    <v-col cols="2">
      <v-card class="mx-4" max-width="320" @click="feed">
        <v-img src="@/assets/imgs/중식.png" height="200px"></v-img>
        <v-spacer></v-spacer>
        <v-spacer></v-spacer>
        <v-card-title> 중식 </v-card-title>

        <v-card-actions>
          <v-btn color="orange lighten-2" text> Explore </v-btn>

          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-col>
    <v-col cols="2">
      <v-card class="mx-4" max-width="320" @click="feed">
        <v-img src="@/assets/imgs/일식.jpg" height="200px"></v-img>
        <v-spacer></v-spacer>
        <v-spacer></v-spacer>
        <v-card-title> 일식 </v-card-title>

        <v-card-actions>
          <v-btn color="orange lighten-2" text> Explore </v-btn>

          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-col>
    <v-col cols="2">
      <v-card class="mx-4" max-width="320" @click="feed">
        <v-img src="@/assets/imgs/카페.jpg" height="200px"></v-img>
        <v-spacer></v-spacer>
        <v-spacer></v-spacer>
        <v-card-title> 카페 </v-card-title>

        <v-card-actions>
          <v-btn color="orange lighten-2" text> Explore </v-btn>

          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-col>
    <v-col cols="2">
      <v-card class="mx-4" max-width="320" @click="feed">
        <v-img src="@/assets/imgs/고기.jpg" height="200px"></v-img>
        <v-spacer></v-spacer>
        <v-spacer></v-spacer>
        <v-card-title> 고기 </v-card-title>

        <v-card-actions>
          <v-btn color="orange lighten-2" text> Explore </v-btn>

          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  methods: {
    feed() {
      this.$router.push({ name: "BoardListPage" });
    },
  },
};
</script>
