package com.kodilla.testing.forum.statistics;

public class CalculateStatistics {
    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double postsPerUser;
    private double commentsPerUser;
    private double commentsPerPost;

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();

        if (usersQuantity != 0 && postsQuantity != 0) {
            postsPerUser = (double) postsQuantity / usersQuantity;
            commentsPerUser = (double) commentsQuantity / usersQuantity;
            commentsPerPost = (double) commentsQuantity / postsQuantity;
        }
    }

    public void showStatistics() {
        System.out.println("\nForumStatistics: \nUsers number: " + usersQuantity +
                "\nPosts number: " + postsQuantity +
                "\nComments number: " + commentsQuantity +
                "\nAverage number of posts per user: " + postsPerUser +
                "\nAverage number of comments per user: " + commentsPerUser +
                "\nAverage number of comments per post: " + commentsPerPost);
    }
}
