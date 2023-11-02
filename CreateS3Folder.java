import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class CreateS3Folder {
    public static void main(String[] args) {
        String bucketName = "s3aws-java-testing-shamsher"; // Replace with your S3 bucket name
        String folderName = "shamsher-folder"; // Replace with the desired folder name
        String key = folderName + "/"; // Add a trailing slash to indicate it's a folder

        AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

        // Create an empty object with metadata to represent the folder
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(0);

        // Put the empty object into the S3 bucket, which creates the folder
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, null, metadata);
        s3Client.putObject(putObjectRequest);

        System.out.println("Folder '" + folderName + "' created in bucket '" + bucketName + "'");
    }
}
